package net.samhouse.impl;

import java.io.PrintStream;

public class Minstrel {
   private PrintStream stream;

   public Minstrel(PrintStream stream) {
       this.stream = stream;
   }

   public void singBeforeQuest() {
       stream.println("Fa la la, the knight is to brave!");
   }

   public void singAfterQuest() {
       stream.println("Tee hee, hee, the brave knight " +
       "did embark on a quest!");
   }
}
