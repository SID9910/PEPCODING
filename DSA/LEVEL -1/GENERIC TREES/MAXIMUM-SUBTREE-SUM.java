public static int Maximumsum =Integer.MIN_VALUE;
public static int MaximumsumNode =0;

public static int MaximumSumNode(Node node )
{
    int sum=node.data;
    for(Node child: node.children){
        int childSum =MaximumSumNode(child);
        sum+=childSum;
    }
    if(sum>Maximumsum){
        MaximumSumNode =node;
        Maximumsum =sum;
    }
    return sum;
}