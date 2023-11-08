public class Rider
	{
		private String name;
		private String team;
		private int sprintPoints;
		private int mountainPoints;
		private int time;
		private String specialty;
		public Rider(String n, String c, int g, int p, int t, String s)
			{
				name = n;
				team = c;
				sprintPoints = g;
				mountainPoints = p;
				time = t;
				specialty = s;
			}
		public String getName()
			{
				return name;
			}
		public String getTeam()
			{
				return team;
			}
		public int getSprintPoints()
			{
				return sprintPoints;
			}
		public int getMountainPoints()
			{
				return mountainPoints;
			}
		public int getTime()
			{
				return time;
			}
		public String getSpecialty()
			{
				return specialty;
			}
		public void setName(String n)
			{
				name = n;
			}
		public void setTeam(String t)
			{
				team = t;
			}
		public void setSprintPoints(int g)
			{
				sprintPoints = g;
			}
		public void setMountainPoints(int p)
			{
				mountainPoints = p;
			}
		public void setTime(int t)
			{
				time = t;
			}
		public void setSpecialty(String s)
			{
				specialty = s;
			}
	}
