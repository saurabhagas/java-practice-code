package com.saurabh.source.common;

public class Cake {
  private Flavor flavor;
  private Size size;
  private Shape shape;
  private String customMessage;

  //DEFAULTS
  private static final Size DEFAULT_SIZE = Size.SMALL;
  private static final Shape DEFAULT_SHAPE = Shape.ROUND;
  private static final Flavor DEFAULT_FLAVOR = Flavor.VANILLA;
  private static final String DEFAULT_CUSTOM_MESSAGE = "Best Wishes!";

  public Cake(Flavor flavor, Size size, Shape shape, String customMessage) {
    this.flavor = flavor;
    this.size = size;
    this.shape = shape;
    this.customMessage = customMessage;
  }

  @Override
  public String toString() {
    return "Cake {Flavor= " + flavor + ", Size= " + size + ", Shape= " + shape + ", Message= " + customMessage + "}";
  }

  public static final class CakeBuilder {
    private Flavor flavor = DEFAULT_FLAVOR;
    private Size size = DEFAULT_SIZE;
    private Shape shape = DEFAULT_SHAPE;
    private String customMessage = DEFAULT_CUSTOM_MESSAGE;

    public static CakeBuilder newBuilder() {
      return new CakeBuilder();
    }

    public CakeBuilder withFlavor(Flavor f) {
      flavor = f;
      return this;
    }

    public CakeBuilder withSize(Size s) {
      size = s;
      return this;
    }

    public CakeBuilder withShape(Shape s) {
      shape = s;
      return this;
    }

    public CakeBuilder withCustomMessage(String msg) {
      customMessage = msg;
      return this;
    }

    public Cake build() {
      return new Cake(flavor, size, shape, customMessage);
    }
  }
}
