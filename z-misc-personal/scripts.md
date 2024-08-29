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