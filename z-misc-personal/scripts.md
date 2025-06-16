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

# Feh Slideshow
`feh --hide-pointer -qrzZFD 6.0 /media/USB/images`

# .bashrc
```sh
alias cs='cd /data/code/Code-Snippets/; nvim'

alias rd1='redshift -t 4200:4200 -b 0.85'
alias rd2='redshift -t 3200:3200 -b 0.725'
alias rd3='redshift -t 2600:2600 -b 0.625'

alias lamps='sudo /opt/lampp/lampp start'
alias lampst='sudo /opt/lampp/lampp stop'
alias lampr='sudo /opt/lampp/lampp restart'

alias ns='feh --hide-pointer -qrzZFD 12.0 /home/.hidden/wall'

alias nd='cp {src/n.zip} {dest/n.zip}; 7za x {dest/n.zip} -o{dest/}'
alias nu='cd {src};  7za a -tzip -p{4ch4n simple} -mem=AES256 n.zip ; cp n.zip {dest/n.zip}'
```

# Timer
https://github.com/rlue/timer
In script 
`lame --decode /home/manan/software/timer-0.1.7/happy.mp3 - | play -v 0.25 -`

`alias tm='AUDIODRIVER=alsa /home/manan/software/timer-0.1.7/timer'`

# Loud beeping laptop
`echo 'blacklist pcspkr' | sudo tee --append /etc/modprobe.d/nobeep.conf`
OR
`rmmod pcspkr ; echo "blacklist pcspkr" >>/etc/modprobe.d/blacklist.conf`
OR
delete `rm /usr/share/sounds/ubuntu/stereo/bell.ogg`
