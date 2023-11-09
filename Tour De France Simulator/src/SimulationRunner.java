import java.util.Scanner;
public class SimulationRunner
	{
		static int playerNumber;
		public static void main(String[] args)
			{
				Database.fillStartList();
				Database.fillStageList();
				Database.fillLeaderboards();
				for(Rider r : Database.startList)
					{
						System.out.println(r.getName());
					}
				createCharacter();
//				for(Stage s : Database.stageList)
//					{
						introStage();
//						stageSetUp();
//						ride();
//						updateStandings();
//					}
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
						System.out.println("[" + counter + "] " + r.getName() + r.getTeam());
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
				int stageNum = 0;
				int climbCount;
				int sprintCount;
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
	}