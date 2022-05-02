for item in $*
sum=0
do
 sum=$(( $sum+$item ))
echo $(( $sum/$# ))
done
