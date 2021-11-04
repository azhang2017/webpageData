import java.io.*;
import java.util.*;

public class GovWebpageData{
  public static void main(String[] args) throws FileNotFoundException{
    File f = new File("all-domains-30-days.csv");
    mostVisits(f);
    mostVisitLeastExit(f,1,0,6);
  }

  public static void mostVisitLeastExit(File f, int indVisit, int indDomain, int indExit) throws FileNotFoundException{
    //create scanner and set delimiter
    Scanner sc = new Scanner(f);
    sc.useDelimiter(",");
    //get the index of exits
    int exitsIndex = indExit;
    int domainIndex = indDomain;
    int visitsIndex = indVisit;
    //create an array with all the domain names
    ArrayList<String> domains = new ArrayList<>();
    //create an array that tracks difference between visits and exits
    ArrayList<Integer> difference = new ArrayList<>();
    int numVisits = 0;
    int numExits = 0;
    //start from line2
    String thisLine = sc.nextLine();
    //while hasNextLine()
    while (sc.hasNextLine()){
      String[] currentLine = sc.nextLine().split(",");
      //store domain in domains
      domains.add(currentLine[domainIndex]);
      //store numvisits
      numVisits = Integer.parseInt(currentLine[visitsIndex]);
      //get exits
      numExits = Integer.parseInt(currentLine[exitsIndex]);
      //get the difference between visits and exits and store in array
      difference.add(numVisits - numExits);
      //go to next line
      sc.nextLine();
    }
    //get the largest difference and get the website name
    int maxDifference = 0;
    String domain = "";
    for (int i = 0; i<difference.size(); i++){
      if (difference.get(i)>maxDifference){
        maxDifference = difference.get(i);
        domain = domains.get(i);
      }
    }
    System.out.println("The domain with the most visits and least exits is "+domain);

  }

  public static void mostVisits(File f) throws FileNotFoundException{
      Scanner sc = new Scanner(f);
      sc.useDelimiter(",");
      //start from line2
      sc.nextLine();
      String domain = sc.next();
      int maxVisits = sc.nextInt();
      String tempDomain = "";
      int tempVisits = 0;
      sc.nextLine();
      while (sc.hasNextLine()){
        //scan for the first block and store it in temp domain
        tempDomain = sc.next();
        //scan the next int and compare it to maxVisits
        tempVisits = sc.nextInt();
        //if the next int is greater than maxVisits, maxVisits = newNum and change domain to temp
        if (tempVisits>maxVisits){
          maxVisits=tempVisits;
          domain = tempDomain;
        }
        //move on to next line
        sc.nextLine();
      }
      //print the domain with most visits
      System.out.println("Domain with most visits: "+domain);
  }


}
