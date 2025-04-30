import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


import java.io.IOException;
import java.util.*;
public class Main {
        public static int[] arr;
        public static int[] tmp;
        public static long sum;
        public static void MergeSort(int s, int e)
        {
                if(e-s <1)
                        return;

                int m = s+ (e-s)/2;
  
                MergeSort(s, m);
                MergeSort(m+1, e);

                for(int i =s; i<=e; i++)
                {
                        tmp[i]=arr[i];
                }

                int k= s;
                int index1 = s;
                int index2 = m+1;

                while(index1<=m && index2 <=e)
                {
                        if(tmp[index1]>tmp[index2])
                        {
                                arr[k]= tmp[index2];
                                sum = sum+index2 -k;
                                k++;
                                index2++;
                        }
                        else
                        {
                                arr[k]=tmp[index1];


                                k++;
                                index1++;
                        }
                }
                /*
                
                while(index1<=m && index2 <=e)
                {
                        if(tmp[index1]<tmp[index2])
                        {
                                arr[k]= tmp[index1];
                                k++;
                                index1++;
                        }
                        else
                        {
                                arr[k]=tmp[index2];
                                sum = sum+index2 -k;

                                k++;
                                index2++;
                        }
                }
                */


                while(index1 <=m)
                {
                        arr[k]= tmp[index1];
                        k++;
                        index1++;
                }
                while(index2 <=e)
                {
                        arr[k]= tmp[index2];
                        k++;
                        index2++;
                }

        }

	public static void main(String[] args) throws IOException 
        {
  
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int N= Integer.parseInt(br.readLine());

                StringTokenizer st = new StringTokenizer(br.readLine());

                arr = new int[N+1];
                tmp = new int[N+1];
                for(int i=1; i<=N; i++)
                {
                        arr[i]=Integer.parseInt(st.nextToken());       
                }
                sum =0;

                MergeSort(1, N);
                
                StringBuilder sb  = new StringBuilder();

                sb.append(sum);

                System.out.println(sb);

                
        }
}
