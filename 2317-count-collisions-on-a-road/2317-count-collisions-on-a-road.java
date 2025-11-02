class Solution {
    public int countCollisions(String directions) {
        char[] directionsTab = directions.toCharArray();
        int collisionCounter = 0;
        int rightDirCars = 0;
        int leftDirCars = 0;
        int lastStayingCar = -1;
        for(int i = 0; i < directionsTab.length; i++){
            if(directionsTab[i] == 'R'){
                rightDirCars += 1;
                if(leftDirCars > 0){
                    collisionCounter += leftDirCars + rightDirCars;
                    rightDirCars = 0;
                    leftDirCars = 0;
                    lastStayingCar = i;
                }
            }else if(directionsTab[i] == 'L'){
                leftDirCars += 1;
                if(rightDirCars > 0){
                    collisionCounter += leftDirCars + rightDirCars;
                    rightDirCars = 0;
                    leftDirCars = 0;
                    lastStayingCar = i;
                }
                if(rightDirCars == 0){
                    if(lastStayingCar != -1 && lastStayingCar < i){
                        collisionCounter += 1;
                        lastStayingCar = i;
                    }
                    leftDirCars = 0;
                }                
            }else if(directionsTab[i] == 'S'){
                lastStayingCar = i;
                if(rightDirCars > 0 && leftDirCars == 0){
                    collisionCounter += rightDirCars;
                    lastStayingCar = i;
                    rightDirCars = 0;
                }
            }
            //System.out.println(directionsTab[i]);
            //System.out.println("before r " + rightDirCars + " l " + leftDirCars + " s " + lastStayingCar + " c " + collisionCounter);
            /*
            if(rightDirCars > 0 && leftDirCars > 0){
                collisionCounter += leftDirCars + rightDirCars;
                rightDirCars = 0;
                leftDirCars = 0;
                lastStayingCar = i;
            }
            if(rightDirCars == 0 && leftDirCars > 0){
                if(lastStayingCar != -1 && lastStayingCar < i){
                    collisionCounter += 1;
                    lastStayingCar = i;
                }
                leftDirCars = 0;
            }
            if(rightDirCars > 0 && leftDirCars == 0 && lastStayingCar == i){
                    collisionCounter += rightDirCars;
                    lastStayingCar = i;
                    rightDirCars = 0;
            }
            */
            //System.out.println("after r " + rightDirCars + " l " + leftDirCars + " s " + lastStayingCar + " c " + collisionCounter);
            //System.out.println();
            
        }
        return collisionCounter;
    }
}