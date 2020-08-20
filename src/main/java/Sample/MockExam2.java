package Sample;

class MockExam2 {
    public int[] solution(int[] answers) {
        int[] arr = new int[3];
        int[] a = {5,1,2,3,4};
        int[] b = {5,2,1,2,3,2,4,2};
        int[] c = {5,3,3,1,1,2,2,4,4,5};

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == a[(i+1)%5]) arr[0]++;
            if(answers[i] == b[(i+1)%8]) arr[1]++;
            if(answers[i] == c[(i+1)%10]) arr[2]++;
        }

        int max = arr[0];

        if(max < arr[1]) max = arr[1];
        if(max < arr[2]) max = arr[2];

        if(max == arr[0] && max == arr[1] && max == arr[2]) return new int[]{1,2,3};
        else if(max == arr[0] && max == arr[1]) return new int[]{1,2};
        else if(max == arr[0] && max == arr[2]) return new int[]{1,3};
        else if(max == arr[1] && max == arr[2]) return new int[]{2,3};
        else if(max == arr[0]) return new int[]{1};
        else if(max == arr[1]) return new int[]{2};

        return new int[]{3};
    }
}
