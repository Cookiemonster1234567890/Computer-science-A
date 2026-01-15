import java.lang.classfile.attribute.SourceFileAttribute;
import java.util.ArrayList;
import java.util.Scanner;

public class CampusHelperRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ask me about a class or a teacher:"); //Beginning sentence to start conversation

        // thingies with locations, times, and teachers
        ArrayList<String> compSciClasses = new ArrayList<>(); //sets up everything for computer science
        compSciClasses.add("comp sci");
        compSciClasses.add("computer science");
        compSciClasses.add("AP computer science");
        compSciClasses.add("coding");
        compSciClasses.add("coding class");
        ArrayList<String> compSciTimes = new ArrayList<>();
        compSciTimes.add("C block");
        ArrayList<String> compSciRooms = new ArrayList<>();
        compSciRooms.add("Room 2.44");
        ArrayList<String> compSciTeachers = new ArrayList<>();
        compSciTeachers.add("Ms S");

        ArrayList<String> chemClasses = new ArrayList<>(); //sets up everything for chemisty
        chemClasses.add("chem");
        chemClasses.add("chemistry");
        chemClasses.add("AP chemistry");
        ArrayList<String> chemTimes = new ArrayList<>();
        chemTimes.add("F block");
        ArrayList<String> chemRooms = new ArrayList<>();
        chemRooms.add("room 2.52");
        ArrayList<String> chemTeachers = new ArrayList<>();
        chemTeachers.add("Mr Alfano");

        ArrayList<String> calcClasses = new ArrayList<>(); //sets up everythinf for calculus
        calcClasses.add("calc");
        calcClasses.add("calculus");
        calcClasses.add("AP calculus");
        calcClasses.add("math");
        calcClasses.add("mathematics");
        ArrayList<String> calcTimes = new ArrayList<>();
        calcTimes.add("H block");
        ArrayList<String> calcRooms = new ArrayList<>();
        calcRooms.add("room 2.69");
        ArrayList<String> calcTeachers = new ArrayList<>();
        calcTeachers.add("Mrs Vreugde");

        ArrayList<String> TeachPrefixes = new ArrayList<>(); //makes sure that for all prefixes of a teacher, it knows there is a teach
        TeachPrefixes.add("Mister");
        TeachPrefixes.add("Miss");
        TeachPrefixes.add("Mr");
        TeachPrefixes.add("Mrs");
        TeachPrefixes.add("Ms");

        while (true) {
            String yourResponse = scanner.nextLine().trim().toLowerCase();
            if (yourResponse.endsWith("?")) {
                yourResponse = yourResponse.substring(0, yourResponse.length() - 1).trim(); //takes away the question mark, to allow user to use a question mark or not in their sentence
            }
            String response = "";

            int whenPos = yourResponse.indexOf("when is"); //for when your sententence is a when question, responds with fitting block
            if (whenPos != -1) {
                String className = yourResponse.substring(whenPos + 8).trim();
                if (compSciClasses.contains(className)) {
                    response = "The " + className + " class is at " + compSciTimes.get(0);
                }
                if (chemClasses.contains(className)) {
                    response = "The " + className + " class is at " + chemTimes.get(0);
                }
                if (calcClasses.contains(className)) {
                    response = "The " + className + " class is at " + calcTimes.get(0);
                }
            }

            int wherePos = yourResponse.indexOf("where is"); //for when your sentence is a where is question, responds with the fitting room
            if (wherePos != -1) {
                String className = yourResponse.substring(wherePos + 9).trim();
                if (compSciClasses.contains(className)) {
                    response = "The " + className + " class is in " + compSciRooms.get(0);
                }
                if (chemClasses.contains(className)) {
                    response = "The " + className + " class is in " + chemRooms.get(0);
                }
                if (calcClasses.contains(className)) {
                    response = "The " + className + " class is in " + calcRooms.get(0);
                }
            }

            int whoTeachesPos = yourResponse.indexOf("who teaches"); //for when your sentences is a who question, it responds with fitting teacher
            if (whoTeachesPos != -1) {
                String className = yourResponse.substring(whoTeachesPos + 12).trim();
                if (compSciClasses.contains(className)) {
                    response = compSciTeachers.get(0) + " teaches " + className;
                }
                if (chemClasses.contains(className)) {
                    response = chemTeachers.get(0) + " teaches " + className;
                }
                if (calcClasses.contains(className)) {
                    response = calcTeachers.get(0) + " teaches " + className;
                }
            }

            for (String prefix : TeachPrefixes) { //I added this for some noteworthy teachers, that if mentions give a specific response
                String lowerPrefix = prefix.toLowerCase();
                int whoIsPos = yourResponse.indexOf("who is " + lowerPrefix.toLowerCase());
                if (whoIsPos != -1) {
                    String teacherName = yourResponse.substring(whoIsPos + 7).trim();
                    // Match known teachers
                    if (teacherName.equals("mrs ray")) {
                        response = "Mrs Ray is the goat dude";
                    } else if (teacherName.equals("mr pratt")) {
                        response = "he does robotics";
                    }
                }
            }

            if (response.equals("")) {
                //if you dont ask him a useful question, his personality is very sassy, he only likes school :/
                final int x = 3;

                int whichResponse = (int) (Math.random() * x);

                if (whichResponse == 0) {
                    response = "not interesting.";
                } else if (whichResponse == 1) {
                    response = "I dont like that";
                } else if (whichResponse == 2) {
                    response = "Please, ask a useful question";
                }

            }
            System.out.println(response); //actually gives you your awnser
        }
    }
}