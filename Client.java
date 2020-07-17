class Client {
  int[][] map = {
    {1, 0, 2},
    {0, 2, 0},
    {2, 0, 1},
  };

  public static void main(String args[]) {
    Client c = new Client();
    c.window();
  }

  public String getContent(int k, int i) {
    switch (k) {
      case 1: return Resource.O[i];
      case 2: return Resource.X[i];
      default: return "   ";
    }
  }

  public void window() {
    System.out.print(" ".repeat(8));
    System.out.print("1");
    System.out.print(" ".repeat(9));
    System.out.print("2");
    System.out.print(" ".repeat(9));
    System.out.println("3");

    System.out.print("   ");
    System.out.println("-".repeat(31));

    for (int i = 0; i < 3; i++) {
      for (int k = 0; k < 3; k++) {
        System.out.print((k == 1) ? " " + i + " " : "   ");
        for (int j = 0; j < 3; j++) {
          System.out.print("|");
          System.out.print("   ");
          System.out.print(getContent(map[i][j], k));
          System.out.print("   ");
        }
        System.out.println("|");
      }

      System.out.print("   ");
      System.out.println("-".repeat(31));

    }

    System.out.println("Ход игрока: 1");
    System.out.println("");
    System.out.println("> ");
  }
}
