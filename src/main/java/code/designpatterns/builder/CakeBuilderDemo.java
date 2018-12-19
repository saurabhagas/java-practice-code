package code.designpatterns.builder;

import code.common.Cake;
import code.common.Flavor;
import code.common.Shape;
import code.common.Size;

public class CakeBuilderDemo {
  public static void main(String[] args) {
    Cake cake1 = Cake.CakeBuilder.newBuilder()
        .withFlavor(Flavor.BLUEBERRY)
        .withShape(Shape.RECTANGULAR)
        .withCustomMessage("Happy Birthday Surbhi")
        .build();
    System.out.println(cake1);

    Cake cake2 = Cake.CakeBuilder.newBuilder()
        .withFlavor(Flavor.WHITE_FOREST)
        .withSize(Size.EXTRA_LARGE)
        .withCustomMessage("Happy Anniversary Rakesh")
        .build();
    System.out.println(cake2);

    Cake cake3 = Cake.CakeBuilder.newBuilder()
        .withShape(Shape.CUSTOM)
        .build();
    System.out.println(cake3);
  }
}
