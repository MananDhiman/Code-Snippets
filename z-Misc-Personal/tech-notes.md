# Linux

## Terminal

`.bashrc` in home is terminal load up file adding command to EOF runs that command.

add `fish` for fish terminal

## Sym Link

After running this command, you will be able to access the '/home/james/transactions.txt' with 'trans.txt'. Any modification to trans.txt will also be reflected in the original file.

always give full path

```sh
ln -s from to

ln -s /archive/google-drive/distractions.txt /home/manan/d.txt
```

## Firewall

```sh
systemctl status firewalld
systemctl stop/start firewalld

firewall-cmd --list-ports

firewall-cmd --add-port 3000/tcp # not persistent. returns to default when device reset
firewall-cmd --permanent --add-port 3000/tcp # didn't work
```

## Port

```sh
sudo fuser -k 81/udp kill port
```

## PostgreSQL EOS

```sh
sudo pacman -Syu postgresql # install

sudo mkdir /var/lib/postgres/data # dir for storage

sudo chown postgres:postgres /var/lib/postgres/data # change owner of dir

sudo -u postgres initdb -D /var/lib/postgres/data # init something

sudo systemctl start postgresql # start db

sudo systemctl status postgresql # check db status

sudo systemctl enable postgresql # persistent enable or disable db

sudo -u postgres psql # enter db with username
```

## MongoDB

```sh
yay -S mongodb-bin mongodb-tools-bin
sudo systemctl enable mongodb
sudo systemctl start mongodb
yay -S mongodb-bin mongodb-tools-bin

# bin name is mongosh
```

## Mysql

```sh
sudo pacman -S mysql
sudo mysql_install_db --user=mysql --basedir=/usr --datadir=/var/lib/mysql

sudo -i

mysql -u root -p
```

## Android Studio Move avd dir

```sh
mv /home/.android/avd /data/software/android-avd

ln -s /data/software/android-avd/avd /home/manand/.android/avd
```

## XAMPP Directory

`yay -S libxcrypt-compat` for xampp err

- Stop xampp: `sudo /opt/lampp/lampp stop`

- Open `/opt/lampp/etc/httpd.conf`

- Change your_folder:

```sh
DocumentRoot "/home/username/your_folder"
<Directory "/home/username/your_folder">
```

- Change **User & Group** value from daemon to:

```
User nobody
Group nogroup
```

in eos had to set group to nobody after checking in /etc/group

set chmod to your_folder with this command

- sudo chmod 777 /home/your_folder

Save the file and start xampp with this command:

sudo /opt/lampp/lampp start

## GRUB Menu

/etc/default/grub

```
GRUB_TIMEOUT = '0'
```

update-grub command, shell script in /usr/sbin/:
**sudo nano /usr/sbin/update-grub**

```
#!/bin/sh
set -e
exec grub-mkconfig -o /boot/grub/grub.cfg "$@"
```

Then run these:

```
sudo chown root:root /usr/sbin/update-grub
sudo chmod 755 /usr/sbin/update-grub
```

## Bluetooth

```sh
sudo pacman -S bluez bluez-utils

sudo systemctl enable bluetooth.service

sudo systemctl start bluetooth.service
```

## Remove password from pdf

```sh
./qpdf.AppImage --decrypt --password=12112002 a.pdf output_file.pdf
```

## Merge PDF

```
pdfunite 1.pdf 2.pdf output.pdf
```

## Convert mp4 to mp3

## All files in single folder

```sh
# Single File
ffmpeg -i input.mp4 -vn audio_only.mp3

# All files in single folder
for f in *.mp4; do
    ffmpeg -i "$f" -vn "${f%.mp4}.mp3"
done
```
