import java.util.Scanner;
public class SimulationRunner
	{
		public static void main(String[] args)
			{
				Database.fillStartList();
				for(Rider r : Database.startList)
					{
						System.out.println(r.getName());
					}
				createCharacter();
//				for(Stage s : Database.stageList)
//					{
//						introStage();
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
			}
	}