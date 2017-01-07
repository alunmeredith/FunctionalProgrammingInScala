package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 | r == c) 1
      else pascal(c,r-1) + pascal(c-1, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balanceInner(chars: List[Char], acc: Int): Int = {
        if (chars.isEmpty | acc < 0) acc
        else if (chars.head == '(') balanceInner(chars.tail, acc + 1)
        else if (chars.head == ')') balanceInner(chars.tail, acc - 1)
        else balanceInner(chars.tail, acc)
      }
      if (balanceInner(chars, 0) == 0) true else false 
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def countChangeInner(money:Int, coins: List[Int], count:Int): Int = {
        if (money < 0) count
        else if (coins.isEmpty) {
          if (money == 0) count + 1 
          else count
        }
        else countChangeInner(money - coins.head, coins, count) + countChangeInner(money, coins.tail, count)
      }
      countChangeInner(money, coins, 0)
    }
  }
