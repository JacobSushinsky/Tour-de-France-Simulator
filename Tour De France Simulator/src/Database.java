import java.util.ArrayList;
public class Database
	{
		static ArrayList <Rider> startList = new ArrayList<Rider>();
		public static void fillStartList()
			{
				startList.add(new Rider("Jonas Vingegaard", "Jumbo-Visma", 0, 0, 0, "GC"));
				startList.add(new Rider("Tadej Pogacar", "UAE", 0, 0, 0, "GC"));
				startList.add(new Rider("Tom Pidcock", "Ineos", 0, 0, 0, "GC"));
				startList.add(new Rider("David Gaudu", "Groupama-FDJ", 0, 0, 0, "GC"));
				startList.add(new Rider("Neilsen Powless", "EF", 0, 0, 0, "GC"));
			}
		static ArrayList <Stage> stageList = new ArrayList<Stage>();
		public static void fillStageList()
			{
				stageList.add(new Stage("Mountain", "Bilbao to Bilbao", 182, 5, 10));
				stageList.add(new Stage("Mountain", "Vitoria-Gasteiz to San Sebastian", 209, 5, 10));
			}
		static ArrayList <Rider> yellowJersey = new ArrayList<Rider>();
		static ArrayList <Rider> greenJersey = new ArrayList<Rider>();
		static ArrayList <Rider> polkaJersey = new ArrayList<Rider>();
		public static void fillLeaderboards()
			{
				for(int i = 0; i < startList.size(); i++)
					{
						yellowJersey.add(startList.get(i));
						greenJersey.add(startList.get(i));
						polkaJersey.add(startList.get(i));
					}
			}
//		public static void updateLeaderboards()
//			{
//				int leader = startList.get(0).getTime();
//				for(int y = 0; y < startList.size(); y++)
//					{
//						if(startList.get(y).getTime() < leader)
//							{
//								leader = startList.get(y).getTime();
//								yellowJersey.
//							}
//					}
//			}

	}