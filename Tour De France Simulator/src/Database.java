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
		static ArrayList <Rider> yellowJersey = new ArrayList<Rider>();
		static ArrayList <Rider> greenJersey = new ArrayList<Rider>();
		static ArrayList <Rider> polkaJersey = new ArrayList<Rider>();
		static ArrayList <Stage> stageList = new ArrayList<Stage>();
		public static void fillStageList()
			{
				stageList.add(new Stage("Mountain", "Bilbao to Bilbao", 182, 5, 10));
				stageList.add(new Stage("Mountain", "Vitoria-Gasteiz to San Sebastian", 209, 5, 10));
			}

	}