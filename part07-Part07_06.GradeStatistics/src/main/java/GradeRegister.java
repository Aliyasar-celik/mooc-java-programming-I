public class GradeRegister {

    int totalPoints = 0;
    int pointCount = 1;

    int point = Integer.valueOf(scanner.nextLine());

    if((point<=100)&&(point>0))
    {
        totalPoints += point;
        pointCount += 1;

    }

    while(point!=-1)
    {

        point = Integer.valueOf(scanner.nextLine());

        if (point <= 100 && point > 0) {
            totalPoints += point;
            pointCount += 1;

        }
    }

    System.out.println("Point average (all): "+totalPoints/(float)(pointCount-1));
}}
