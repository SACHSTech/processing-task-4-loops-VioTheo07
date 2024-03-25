import processing.core.PApplet;

public class Sketch extends PApplet {

  // initialize variables
  // Background Width and Height

  int intBackGSize = 800;

  // quadrant width and height

  int intQuadSize = intBackGSize / 2;

  // quadrant 1
  // amount of squares per row and column

  int intSquare = 10;

  // top left corner x coordinate

  int intGridPositionX = 0;

  // top left corner y coordinate

  int intGridPositionY = 0;

  // quadrant 2
  // diameter of the circles for the image

  int intCircleSize = intBackGSize / (2 * 5);

  // top left corner x coordinate

  int intCirclePositionX = intBackGSize * intCircleSize;

  // top left corner y coordinate

  int intCirclePositionY = intCircleSize;

  // vertical distance added to the first circle...

  int intRow;

  // horizontal distance added to the first circle...

  int intColumn;

  // x coordinate of each circle and on

  int intCircleX;

  // y coordinate of each circle and on

  int intCircleY;


  // quadrant three
  // gradient of the colour required

  int intRGB;

  // position of the gradient rectangle on the x - axis

  float fltRectPositionX;

  // width of each rectangle

  float fltRectangleWidth = (float) intQuadSize / (float) 255;


  // quadrant four

  // diameter of the centre of the flower

  float fltCenterSize = intQuadSize / 5;

  // x and y corrdinate of the center of the flower

  int intCenterPosition = intQuadSize + intQuadSize / 2;

  // petal length

  float fltPetalLength = (float) intQuadSize * (float) 0.25;

  // petal width

  float fltPetalWidth = (float) intQuadSize * (float) 0.75;


  // background size once again
  public void settings() {
    size(intBackGSize, intBackGSize);
  }

  // Background Colour
  public void setup() {
    background(255, 255, 255);
  }

  // Drawing logic for both quadrants
  public void draw() {
    stroke(0, 0, 0);
    // quadrant one

    // lines upon the x - axis
    for (int i = 0; i <= intSquare; i++) {
      intGridPositionX = i * (intQuadSize / intSquare);
      line(intGridPositionX, 0, intGridPositionX, intQuadSize);
    }
    // lines upon the y - axis
    for (int i = 0; i <= intSquare; i++) {
      intGridPositionY = i * (intQuadSize / intSquare);
      line(0, intGridPositionY, intQuadSize, intGridPositionY);
    }

    // quadrant two

    int circleGapX = (intQuadSize - 2 * intCircleSize) / 8; // Gap between circles horizontally
    int circleGapY = (intQuadSize - 2 * intCircleSize) / 8; // Gap between circles vertically

  for (int i = 0; i < 25; i++) {
    int row = i / 5; 
    int col = i % 5; 
    intCirclePositionX = intQuadSize + circleGapX + col * ((intQuadSize - 2 * circleGapX) / 5);
    intCirclePositionY = circleGapY + row * ((intQuadSize - 2 * circleGapY) / 5);

    fill(200, 0, 100);
    ellipse(intCirclePositionX, intCirclePositionY, intCircleSize / 2, intCircleSize / 2); 

    // quadrant three
    for (int x = 0; x <= 255; x++) {
      intRGB = x;
      fltRectPositionX = x * fltRectangleWidth;

      stroke(intRGB);
      fill(intRGB);
      rect(fltRectPositionX, (float) intQuadSize, fltRectangleWidth, (float) intQuadSize);
    }
  }
  // quadrant four

  // need to change the origin anf scale to as of quadrant 4
  translate(intCenterPosition, intCenterPosition);

  // change the outline to black
  stroke(0);

  // change the colour to the required orange
  fill(255, 140, 0);

  for (int y = 0; y < 8; y++) {
    rotate(radians(45));
    ellipse(fltCenterSize / 2 + fltPetalLength / 2, 0, fltCenterSize + fltPetalLength, fltCenterSize);
  }
  // draw the center of the flower
  stroke(0, 100, 25);
  fill( 0, 100, 25);
  ellipse(0, 0, fltCenterSize, fltCenterSize);
  }
}