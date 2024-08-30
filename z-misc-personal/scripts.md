# Android Project to Dropbox
```sh
# run dropbox
# dropbox
cd /data/software/linux/dropbox-dist/
./dropboxd

echo "hoping dbox running"

# wait for dropbox to launch
sleep 10

while true
do
    # get current time
	x=$(date)
	echo "Copied on $x"

    # copy files from android project src to dropbox dir
	# cp -u -r /data/code/htdocs/current-projects/android-speedy-solver/app/src/main/ /home/manan/Dropbox/android-speedy-solver/
	rsync -avu /data/code/htdocs/current-projects/android-speedy-solver/app/src/main/ /home/manan/Dropbox/android-speedy-solver/ --delete

	sleep 25
done
```

# Laptop Battery Stats
```sh
i=1
sum=0
time_interval=3			# can modify as need

while true
do

curr=$(cat /sys/class/power_supply/BAT0/power_now) # output example (mW): 3290000

# to get output in Wh
curr=$(($curr/10000)) 		# remove least significant places (redundant 0)
curr_decimal="${curr:0-2}"	# get decimal part
sum=$(($sum+$curr))		# get sum to calculate running average
curr=$(($curr/100))		# remove decimal part

avg=$(($sum/$i))
echo "Current Usage = $curr.$curr_decimal        i = $i ($(($i*$time_interval))s)     Avg = $(($sum/$i))"
i=$(($i+1))

sleep $time_interval
done
```