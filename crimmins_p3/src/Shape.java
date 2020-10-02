public abstract class Shape {
    public abstract String getName();
    public abstract double getArea();
}

abstract class Shape2D extends Shape {
    public abstract String getName();
    public abstract double getArea();
}

abstract class Shape3D extends Shape {
    public abstract String getName();
    public abstract double getArea();
    public abstract double getVolume();
}

class Square extends Shape2D {
    private static String Name;
    private final double Length;

    public Square(double Length) {
        this.Name = "square";
        this.Length = Length;
    }

    public String getName() {
        return "square";
    }

    public double getArea() {
        return Length * Length;
    }
}

class Triangle extends Shape2D {
    private static String Name;
    private final double Height;
    private final double Length;

    public Triangle(double Height, double Length) {
        this.Name = "triangle";
        this.Height = Height;
        this.Length = Length;
    }

    public String getName() {
        return "triangle";
    }

    public double getArea() {
        return Height * Length * 0.5;
    }
}

class Circle extends Shape2D {
    private static String Name;
    private final double Radius;

    public Circle(double Radius) {
        this.Name = "circle";
        this.Radius = Radius;
    }

    public String getName() {
        return "circle";
    }

    public double getArea() {
        return Math.PI * Math.pow(Radius, 2);
    }
}

class Cube extends Shape3D {
    private static String Name;
    private final double Radius;

    public Cube(double Radius) {
        this.Name = "cube";
        this.Radius = Radius;
    }

    public String getName() {
        return "cube";
    }

    public double getArea() {
        return Radius * Radius * 6;
    }

    public double getVolume() {
        return Radius * Radius * Radius;
    }
}

class Pyramid extends Shape3D {
    private static String Name;
    private final double Base;
    private final double Width;
    private final double Height;

    public Pyramid(double Base, double Width, double Height) {
        this.Name = "pyramid";
        this.Base = Base;
        this.Width = Width;
        this.Height = Height;

    }

    public String getName() {
        return "pyramid";
    }

    public double getArea() {
        return (Base * Width) + (Base * Math.sqrt(Math.pow(Width / 2, 2) +
                Math.pow(Height, 2))) + (Width * Math.sqrt(Math.pow(Base / 2, 2) + Math.pow(Height, 2)));
    }

    public double getVolume() {
        return (0.333333) * Base * Width * Height;
    }
}

class Sphere extends Shape3D {
    private static String Name;
    private final double Radius;

    public Sphere(double Radius) {
        this.Name = "sphere";
        this.Radius = Radius;
    }

    public String getName() {
        return "sphere";
    }

    public double getArea() {
        return 4 * Math.PI * Math.pow(Radius, 2);
    }

    public double getVolume() {
        return 1.3333333 * Math.PI * Math.pow(Radius, 3);
    }
}
