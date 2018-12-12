package gui_fx.rotates;

import gui_fx.Controller;

public class RotateArrow
{
    private static RotateArrow instance = null;

    public static RotateArrow getInstance()
    {
        if (instance == null)
            instance = new RotateArrow();

        return instance;
    }

    public int getRotateValue()
    {
        String windDir = Controller.WIND_DIRECTION;

        switch(windDir)
        {
            case "N":
                return RotateProperties.N.getDegree();
            case "S":
                return RotateProperties.S.getDegree();
            case "E":
                return RotateProperties.E.getDegree();
            case "W":
                return RotateProperties.W.getDegree();
            case "NE":
                return RotateProperties.NE.getDegree();
            case "SE":
                return RotateProperties.SE.getDegree();
            case "SW":
                return RotateProperties.SW.getDegree();
            case "NW":
                return RotateProperties.NW.getDegree();
            case "NNE":
                return RotateProperties.NNE.getDegree();
            case "ENE":
                return RotateProperties.ENE.getDegree();
            case "ESE":
                return RotateProperties.ESE.getDegree();
            case "SSE":
                return RotateProperties.SSE.getDegree();
            case "SSW":
                return RotateProperties.SSW.getDegree();
            case "WSW":
                return RotateProperties.WSW.getDegree();
            case "WNW":
                return RotateProperties.WNW.getDegree();
            case "NNW":
                return RotateProperties.NNW.getDegree();
            default:
                return 0;
        }
    }
}
