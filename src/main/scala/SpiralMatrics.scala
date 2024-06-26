class SpiralMatrix(private var sideSize: Int){
  private var matrix = makeSpiral(sideSize)

  def toArray: Array[Array[Int]] = matrix

  def setSize(sideSize: Int): Unit = {
    this.sideSize = sideSize
    matrix = makeSpiral(sideSize)
  }

  def getSize(): Int = sideSize

  def printMatrix(adjustSize: Boolean = false, adjustChar: Char = ' ', separator: String = " "): Unit = {
    var amountOfAdjustments = 0
    for (i <- 0 until sideSize){
      for (j <- 0 until sideSize){
        if (adjustSize) {
          amountOfAdjustments = (sideSize*sideSize).toString.length - (matrix(i)(j).toString.length)
        }
        print(adjustChar.toString * amountOfAdjustments + matrix(i)(j))
        if (j != sideSize - 1) print(separator)

      }
      println()
    }
  }

  def apply(row: Int): Array[Int] = matrix(row)

  private def makeSpiral(n: Int): Array[Array[Int]] = {
    var leftBorderX = 0
    var rightBorderX = n - 1
    var topBorderY = 0
    var bottomBorderY = n - 1
    var x = 0
    var y = 0
    var direction = 0
    var value = 1
    val matrix = Array.ofDim[Int](n, n)
    while (value <= n * n ){
      //  matrix(x)(y) was rewritten to matrix(y)(x) because the first index indicates rows and the second index indicates columns
      matrix(y)(x) = value
      value += 1
      if (direction == 0) {
        x += 1
        if (x == rightBorderX) {
          direction = 1
          topBorderY += 1
        }
      } else if (direction == 1) {
        y += 1
        if (y == bottomBorderY){
          direction = 2
          rightBorderX -= 1
        }
      } else if (direction == 2){
        x -= 1
        if (x == leftBorderX) {
          direction = 3
          bottomBorderY -= 1
        }
      } else if (direction == 3) {
        y -= 1
        if (y == topBorderY){
          direction = 0
          leftBorderX += 1
        }
      }
    }
    matrix
  }
}