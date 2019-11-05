package gui_fx.rotates;

public enum RotateProperties
{
    N(0),
    S(180),
    E(90),
    W(270),
    NE(45),
    SE(135),
    SW(225),
    NW(315),
    NNE(25),
    ENE(65),
    ESE(115),
    SSE(155),
    SSW(205),
    WSW(245),
    WNW(295),
    NNW(335);

    int degree;

    RotateProperties(int degree)
    {
        this.degree = degree;
    }

    public int getDegree()
    {
        return this.degree;
    }


}
