import java.util.ArrayList;

public class GradeRegister {

    private int pointTotals = 0;
    private int passingPointTotals;
    private int pointCount = 0;
    private int passingPointCount;
    private ArrayList<Integer> pointsList;
    private int[] gradeList = new int [6];

    public int[] getGradeList() {
        return gradeList;
    }

    public GradeRegister() {
        pointsList = new ArrayList<Integer>();
    }

    public float averageOfPoints() {

        // added if the point total needs to be calculated again.
        // for (int point : pointsList) {
        //     this.pointTotals += point;
        // }
        return (this.pointCount == 0) ? 0.0f : (float) this.pointTotals / this.pointCount;
    }

    public void addPoint(int point) {

        this.pointTotals += point;
        this.pointCount += 1;
        if (point >= 50) {
            this.passingPointTotals += point;
            this.passingPointCount += 1;

            if (point < 60){
                this.gradeList[1] += 1;
            }else if (point < 70){
                this.gradeList[2] += 1;
            }else if (point < 80){
                this.gradeList[3] += 1;
            }else if (point < 90){
                this.gradeList[4] += 1; 
            }else{
                this.gradeList[5] += 1;
            }
        }else{
            this.gradeList[0] += 1;
        }

    }

    public float averageOfPassingPoints() {
        // added if the point total needs to be calculated again.
        // for (int point : pointsList) {
        //     if (point >= 50) {
        //         this.passingPointCount += point;
        //     }
        // }
        return (this.passingPointCount == 0) ? 0.0f : (float) this.passingPointTotals / this.passingPointCount;

    }

    public float passPercentage(){

        return (this.passingPointCount == 0) ? 0.0f : 100*((float)this.passingPointCount/this.pointCount);

        
    }

}
