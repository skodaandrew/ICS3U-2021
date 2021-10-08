package week4;

public class BayviewGlenPools {
    public static void main(String[] args){
        final int length = 20;
        final int width = 8;
        final int shallowLength = 5;
        final int transition = 7;
        final int shallowHeight = 8;
        final int deepHeight = 8;

        final int linerCost = 2;
        
        System.out.println(getVolume(length, width, shallowHeight, shallowLength, transition, deepHeight));

        double volume = getVolume(length, width, shallowHeight, shallowLength, transition, deepHeight);

       // double surfaceArea = getSurfaceArea(length, width, shallowHeight, shallowLength, transition, deepHeight);

    }

    //private static double getSurfaceArea(int length, int width, int shallowHeight, int shallowLength, int transition, int deepHeight) {
        
    //}

    private static double getVolume(int length, int width, int shallowHeight, int shallowLength, int transition, int deepHeight){
        double Base = Math.sqrt(Math.pow(transition, 2)) - Math.pow(deepHeight - shallowHeight, 2);
        double deepLength = length - shallowLength - transition - Base;
        
        double deepvol = deepHeight * deepLength * width;
        double shallowVolume = shallowHeight * shallowLength * width;

        double transitionvolume = Base * shallowHeight * width;
        transitionvolume += width * (deepHeight - shallowHeight) * Base * 0.5;

        return transitionvolume + shallowVolume + deepvol;
    }
    
}
