# Basic
```sh
# simply writing line runs that command

# declare and assign variable
i=5

# print value
echo "$i"

# arithmetic expression
sum=$(($i+1))
```

## Loop
```sh
while [ $a -le 1 ]
do

# code

done
```

# System Tasks

# Misc
```sh
# run command and get output
bat_usage=$(cat /sys/class/power_supply/BAT0/power_now)

# sleep
sleep 4 # seconds

# file handling
cp -u [src] [dest] # copies if src file newer than destination
```