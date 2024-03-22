package app.organicmaps.routing;

import androidx.annotation.NonNull;

import app.organicmaps.settings.RoadType;

import java.util.HashSet;
import java.util.Set;

public class RoutingOptions
{
  public static void addOption(@NonNull RoadType roadType)
  {
    nativeAddOption(roadType.ordinal());
  }

  public static void removeOption(@NonNull RoadType roadType)
  {
    nativeRemoveOption(roadType.ordinal());
  }

  public static boolean hasOption(@NonNull RoadType roadType)
  {
    return nativeHasOption(roadType.ordinal());
  }

  private static native void nativeAddOption(int option);
  private static native void nativeRemoveOption(int option);
  private static native boolean nativeHasOption(int option);

  public static int hasAnyOptions()
  { int i=0;
    for (RoadType each : RoadType.values())
    {
      if (hasOption(each))
        i++;
    }
    return i;
  }

  @NonNull
  public static Set<RoadType> getActiveRoadTypes()
  {
    Set<RoadType> roadTypes = new HashSet<>();
    for (RoadType each : RoadType.values())
    {
      if (hasOption(each))
        roadTypes.add(each);
    }
    return roadTypes;
  }
}
