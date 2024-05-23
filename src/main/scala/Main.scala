object Main extends App{
  // creating a spiral matrix with side size 5
  val spiral = new SpiralMatrix(5)

  println("printing a matrix without adjusting")
  spiral.printMatrix()

  println("printing a matrix with adjusting")
  spiral.printMatrix(true)

  println("printing a matrix without adjusting with a custom separator")
  spiral.printMatrix(separator = "-")

  println("printing a matrix with adjusting, custom separator and a custom adjustChar")
  spiral.printMatrix(true, '-', "-")

  println("changing a size of a spiral matrix")
  spiral.setSize(2)
  spiral.printMatrix(true)

  println("iterating trough a matrix")
  for (i <- 0 until spiral.getSize()) {
    for (j  <- 0 until spiral.getSize()) {
      println(s"Matrix($i)($j) = ${spiral(i)(j)}")
    }
  }

}
