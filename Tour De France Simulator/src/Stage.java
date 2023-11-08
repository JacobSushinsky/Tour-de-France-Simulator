public class Stage
	{
		private String stageType;
		private String stageName;
		private int distance;
		private int greenPoints;
		private int mountainPoints;
//		private Sprint sprint;
//		private Climb climb;
		public Stage(String t; String n; int d; int g; int m)
			{
				t = stageType;
				n = stageName;
				d = distance;
				g = greenPoints; 
				m = mountainPoints;
			}
		public String getStageType()
		{
			return stageType;
		}
		public String getStageName()
		{
			return stageName;
		}
		public int getDistance()
		{
			return distance;
		}
		public int getGreenPoints()
		{
			return greenPoints;
		}
		public int getMountainPoints()
		{
			return mountainPoints;
		}
		public void setStageType(String t)
		{
			stageType = t;
		}
		public void setStageName(String n)
		{
			stageName = n;
		}
		public void setDistance(int d)
		{
			distance = d;
		}
		public void setGreenPoints(int g)
		{
			greenPoints = g;
		}
		public void setMountainPoints(int m)
		{
			mountainPoints = m;
		}
	}
