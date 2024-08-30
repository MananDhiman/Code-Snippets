# Software List

**Partitions:** /data -> /code, /software, /google-drive

May also mount to ~/code, ~/software, ~/google-drive

## Web Downloads
**AppImage / compiled binary:**
joplin / notesnook, redshift gui, postman, beekeeper, thunderbird, gimp

**.tar.gz :**
android studio, intellij, vscode, sublime text

**xampp / lampp**
Install .run from website. /opt/lampp/etc/httpd.conf -> modify DocumentRoot


**Sublime LSP Setup:**
Tools -> Package Control -> Install. After installed, install package lsp, and then lsp for langs

## Always Install (Pacman + yay (endeavour-os))

### Pacman Main (sudo pacman -Syu)

Personal

```sh
"audacious | strawberry" calibre chromium firefox flatpak geoclue2 gimp gtk2 inkscape
kcharselect hunspell-en_gb libreoffice-fresh mpv noto-fonts noto-fonts-emoji
obs-studio  qbittorrent qpdf redshift syncthing torbrowser-launcher
```

Dev Only

```sh
android-tools composer go intellij-idea-community-edition jdk21-openjdk
kotlin mariadb maven neovim nodejs-lts-iron npm php php-gd postgresql
python python-pip
```

### AUR Main (yay -Syu)

```sh
dropbox grive ttf-ms-fonts github-desktop-bin libxcrypt-compat
```

## Pacman Optional

```
bluez bluez-utils blueman "gnome-disk-utility | partitionmananger" "filelight | baobab"
flameshot gpaste gnome-keyring noto-fonts-cjk
nfs-utils noto-fonts-extra qutebrowser midori scrcpy signal-desktop
```
XFCE clipboard
`sudo pacman -S xfce4-clipman-plugin; xfce4-popup-clipman; xfce4-clipman-history`


### AUR Optional

```sh
otpclient albert
tk # built in python gui
```

Dev Only

```sh
mongodb-bin mongodb-compass mongodb-tools-bin mongosh-bin
```

### Flatpak

- TOTP Authenticator -> com.belmoussaoui.Authenticator
- GitHub Desktop -> io.github.shiftey.Desktop

## APT package manager

```sh
sudo apt update
sudo apt install android-tools-adb android-tools-fastboot audacious calibre
chromium firefox flameshot geoclue-2.0 (default-jdk) openjdk-17-jdk otpclient
hunspell-dictionary-en-gb hunspell-en-gb libreoffice mpv python3 nodejs npm
qbittorrent qpdf syncthing torbrowser-launcher

gnome-disk-utility | partitionmanager filelight gnome-keyring qutebrowser
```
* sudo apt install nvidia-driver
* sudo apt install linux-image-6.5
Not Found:
- grive download from github and build from source
- noto-fonts are 'fonts-noto'
- github-desktop use flatpak
gtk2 noto-fonts
github-desktop grive ms-fonts albert*

### Ubuntu fonts audio codecs
apt install ubuntu-restricted-extras

### i3 wm
#### Clipboard
https://github.com/erebe/greenclip (4mb exec)

** config **
`exec /data/software/linux/greenclip/greenclip daemon`

`bindsym $mod+x exec rofi -modi "clipboard:/data/software/linux/greenclip/greenclip print" -show clipboard -run-command '{cmd}'`



## Flatpak
```
flatpak remote-add --if-not-exists flathub https://flathub.org/repo/flathub.flatpakrepo
flatpak search shiftkey
flatpak install io.github.shiftey.Desktop
```
Authenticator may not have access to filesystem
`sudo flatpak override com.belmoussaoui.Authenticator --filesystem=host`
## Install Gnome DE From Arch CLI

```sh
sudo pacman -S gnome-shell gnome-terminal gdm (lightdm) xorg-xwayland xorg-xlsclients

sudo systemctl enable gdm

sudo pacman -S gnome-calculator gnome-control-center gnome-disk-utility gnome-keyring gnome-menus gnome-tweaks mutter gnome-shell-extensions

yay -S gnome-browser-connector
pacman -S  xdg-desktop-portal
```

Extensions:
ArcMenu, Clipboard Indicator, CHC-E Hot corner, Dash to Panel, No overview at startup

# Windows
helix editor shortcut
```bat
start "" ""D:\software\installed\helix\hx.exe"" "D:\code\Code-Snippets"
```
## Mongo db do not install as service windows
`mongod --port 27017 --dbpath C:\MongoDB\data\db`

## AVD Home if path changed for flutter or react native
<img src="../_images/avd_home.png" />

## Laptop Sys sound disable
`rmmod pcspkr ; echo "blacklist pcspkr" >>/etc/modprobe.d/blacklist.conf`