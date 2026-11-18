# Software List

## Web Downloads
**Appimage or zip**

joplin, gimp, libreoffice, vlc, sublime text, gitkraken, redshift gui, PCSX2, PPSSPP

**Sublime LSP Setup:**

Tools -> Package Control -> Install. After installed, install package lsp, and then lsp for langs

## EOS Sway (Pacman + yay)
EOS install, get sway config from [Community Edition Github](https://github.com/EndeavourOS-Community-Editions/sway), install without desktop environment (be wary of password issue) 

### sudo pacman -Syu
Essential
```sh
sudo pacman -Syu strawberry qbittorrent jdk25-openjdk python-pip python-lsp-server

yay -S brave-bin github-desktop-bin
```
Optional
```sh
sudo pacman -Syu gnome-disk-utility baobab calibre chromium firefox hunspell-en_gb libreoffice-fresh mpv noto-fonts noto-fonts-emoji

sudo pacman -Syu android-tools docker go kotlin mariadb maven neovim nodejs-lts-krypton npm php php-gd

yay -S jdtls gopls rofi-greenclip ttf-ms-fonts libxcrypt-compat
```

**Install Databases**
```sh
sudo systemctl enable docker

sudo docker run -d --name mongo-demo -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -p 27017:27017 -v mongodemo:/data/db  mongo

sudo docker run --name some-postgres -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=admin -p 5432:5432 -v postgres_data:/var/lib/postgresql/data -d postgres
```
** neovim clipboard **

`sudo pacman -S xclip`

Line 1 in init.lua
vim.api.nvim_set_option("clipboard", "unnamedplus")

Line 119 in init.lua
vim.opt.clipboard = 'unnamedplus'


## Laptop Sys sound disable
`rmmod pcspkr ; echo "blacklist pcspkr" >>/etc/modprobe.d/blacklist.conf`