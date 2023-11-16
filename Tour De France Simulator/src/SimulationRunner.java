import java.util.Scanner;
public class SimulationRunner
	{
		static int playerNumber;
		static int climbCount;
		static int sprintCount;
		static int stageNum;
		static boolean win;
		public static void main(String[] args)
			{
				Database.fillStartList();
				Database.fillStageList();
				Database.fillLeaderboards();
				createCharacter();
				int counter = 1;
				for(Rider r : Database.startList)
					{
						System.out.println("[" + counter + "] " + r.getName() + " " + r.getTeam());
						counter ++;
					}
				for(Stage s : Database.stageList)
					{
						introStage();
						ride();
						updateStandings();
					}
			}
		public static void createCharacter()
			{
				String [] specialties = {"GC", "Sprint", "Leadout", "Domestique", "Hybrid"};
				System.out.println("Welcome to the Tour de France! As a new rider, we will need you to give us some information about who you are. "
						+ "Let's start by getting your name, followed by the number next to the specialty you would like to have, immediately followed by the number next to the rider you would like to replace."
						+ "The rider you choose will determine your team, and therefore, your teammates/rivals for the tour.");
				for(int i = 0; i < specialties.length; i++)
					{
						int count = i+1;
						System.out.println("[" + count + "] " + specialties[i]);
					}
				System.out.println();
				int counter = 1;
				for(Rider r : Database.startList)
					{
						System.out.println("[" + counter + "] " + r.getName() + " " + r.getTeam());
						counter ++;
					}
				Scanner userInput = new Scanner(System.in);
				String input = userInput.nextLine();
				int space = input.lastIndexOf(" ");
				String name = input.substring(0, space);
				String specialty = input.substring(space + 1, space + 2);
				String replaceRider = input.substring(space + 2);
				int specialtyNum = Integer.parseInt(specialty);
				specialtyNum--;
				int replaceNum = Integer.parseInt(replaceRider);
				replaceNum--;
				Database.startList.get(replaceNum).setName(name);
				Database.startList.get(replaceNum).setSpecialty(specialties[specialtyNum]);
				playerNumber = replaceNum;
			}
		public static void introStage()
			{
				int stageCount = 1;
				stageNum = 0;
				if(Database.stageList.get(stageNum).getStageType().equals("Mountain"))
					{
						climbCount = (int)(Math.random()*3)+3;
						sprintCount = (int)(Math.random()*3);
					}
				else 
					{
						climbCount = 1;
						sprintCount = 3;
					}
				System.out.println("Welcome to stage " + stageCount + " of the Tour de France! Today's stage is a " + Database.stageList.get(stageNum).getStageType() + 
						"stage, stretching " + Database.stageList.get(stageNum).getDistance() + "km, from " + Database.stageList.get(stageNum).getStageName() + ". " 
						+ "There are " + climbCount + " climbs and " + sprintCount + " sprint points on the route, making " +  Database.stageList.get(stageNum).getMountainPoints()
						+ " Polka-Dot Jersey Points and " + Database.stageList.get(stageNum).getGreenPoints() + " Green Jersey Points available. Good luck today!");
				stageCount++;
				stageNum++;
			}
		public static void ride()
			{
				int stageCount = stageNum + 1;
				int gPoints;
				int fatigue = 0;
				int teamFatigue = 0;
				int minutes;
				int chance;
				int climbPoints = Database.stageList.get(stageNum).getMountainPoints() / climbCount;
				if(sprintCount > 0)
					{
						gPoints = Database.stageList.get(stageNum).getGreenPoints() / sprintCount;
					}
				else
					{
						gPoints = Database.stageList.get(stageNum).getGreenPoints();
					}
				for(int i = 0; i < climbCount; i++)
					{
						Scanner userInput = new Scanner(System.in);
						System.out.println("You've just made it to the bottom of a climb. There are " + climbPoints + " KOM points up for grabs. Would you like to attack on this climb? y/n");
						String answer = userInput.nextLine();
						if(answer.equalsIgnoreCase("y"))
							{
								Database.startList.get(playerNumber).setMountainPoints(Database.startList.get(playerNumber).getMountainPoints() + climbPoints);
								fatigue += 10;
								System.out.println("You made an attack and though you lost some energy, you won the points! You now have "
								+ Database.startList.get(playerNumber).getMountainPoints() + " KOM points!");
							}
						else
							{
								System.out.println("Good strategy! Even though you didn't get any points this time, you saved your strength for the stage win");
							}
					}
				for(int i = 0; i < sprintCount; i++)
					{
						Scanner userInput = new Scanner(System.in);
						System.out.println("You've just made it to the sprint point. there are " + gPoints + " green jersey points up for grabs, and your team is willing to do a leadout."
								+ " Will you use your leadout team? y/n");
						String answer = userInput.nextLine();
						if(answer.equalsIgnoreCase("y"))
							{
								Database.startList.get(playerNumber).setSprintPoints(Database.startList.get(playerNumber).getSprintPoints() + gPoints);
								teamFatigue += 10;
								System.out.println("You made an attack and though you lost some energy, you won the points! You now have "
								+ Database.startList.get(playerNumber).getSprintPoints() + " green jersey points!");
							}
						else
							{
								System.out.println("Good strategy! Even though you didn't get any points this time, you saved your strength for the stage win");
							}
					}
				if(Database.stageList.get(stageNum).getStageType().equals("Mountain"))
					{
						System.out.println("You are now towards the end of the stage. Because of the fatigue you've built up during the stage, you will have to dig deep to be able to " + 
						"win the stage. As you get towards the top of the last climb and the end of the stage, your opponent attacks. Can you go with it?");
						Scanner userInput = new Scanner(System.in);
						String answer = userInput.nextLine();
						if(fatigue > 25)
							{
								chance = (int)(Math.random()*6);
							}
						else if(fatigue > 15 && fatigue < 25)
							{
								chance = (int)(Math.random()*9);
							}
						else
							{
								chance = (int)(Math.random()*15);
							}
						if(chance > 3)
							{
								win = true;
							}
						else
							{
								win = false;
							}
						if(win)
							{
								minutes = Database.stageList.get(stageNum).getDistance() * 2;
								System.out.println("Congratulations! You won stage " + stageCount + ", " + Database.stageList.get(stageNum).getStageName() + "! As a result, you" +
							" earned " + Database.stageList.get(stageNum).getMountainPoints() + " mountain points and took " + minutes + " minutes to complete the stage. Congratulations!");
							}
						else
							{
								minutes = Database.stageList.get(stageNum).getDistance() * 3;
								System.out.println("Unfortunately, you built up too much fatigue to be able to cover the opponent's attack. This means that you got no points and are"
										+ " behind in the yellow jersey standings. Good luck tomorrow, you'll need it!");
							}
					}
			}
		public static void updateStandings()
			{
				int minutes;
				int seconds;
				if(win)
					{
						minutes = Database.stageList.get(stageNum).getDistance() * 3;
						seconds = minutes * 60;
						for(int i = 0; i < Database.startList.size(); i++)
							{
								Database.startList.get(i).setTime(Database.startList.get(playerNumber).getTime() + seconds);
							}
						minutes = Database.stageList.get(stageNum).getDistance() * 2;
						seconds = minutes * 60;
						Database.startList.get(playerNumber).setTime(Database.startList.get(playerNumber).getTime() + seconds);
					}
				else
					{
						minutes = Database.stageList.get(stageNum).getDistance() * 2;
						seconds = minutes * 60;
						for(int i = 0; i < Database.startList.size(); i++)
							{
								Database.startList.get(i).setTime(Database.startList.get(playerNumber).getTime() + seconds);
							}
						minutes = Database.stageList.get(stageNum).getDistance() * 3;
						seconds = minutes * 60;
						Database.startList.get(playerNumber).setTime(Database.startList.get(playerNumber).getTime() + seconds);
					}
				int lowestTime = 1000000000;
				int checkingTime;
				int leader = 0;
				for(int i = 0; i < Database.startList.size(); i++)
					{
						checkingTime = Database.startList.get(i).getTime();
						if(checkingTime < lowestTime)
							{
								lowestTime = checkingTime;
								leader = i;
							}
					}
				System.out.println("The leader of the yellow jersey standings at this point is " + Database.startList.get(leader).getName());
			}
	}