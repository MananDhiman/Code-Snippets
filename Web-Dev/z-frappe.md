# Original Source
https://frappeframework.com/docs/user/en/installation

## Core components: 
python (>=3.10), NodeJS (>=18), MariaDB (>=10.6)

Advisable to install each component separately as faults are easy to diagnose

# Installing Core Components:
`sudo apt install python3 git redis`

## Installing NodeJS
Source: https://github.com/nodesource/distributions#installation-instructions

There are some easier methods, but those didn't work for me
```sh
sudo apt-get install python-software-properties software-properties-common

sudo apt-get install -y ca-certificates curl gnupg

sudo mkdir -p /etc/apt/keyrings

curl -fsSL https://deb.nodesource.com/gpgkey/nodesource-repo.gpg.key | sudo gpg --dearmor -o /etc/apt/keyrings/nodesource.gpg

NODE_MAJOR=18

echo "deb [signed-by=/etc/apt/keyrings/nodesource.gpg] https://deb.nodesource.com/node_$NODE_MAJOR.x nodistro main" | sudo tee /etc/apt/sources.list.d/nodesource.list

sudo apt-get update

sudo apt-get install nodejs -y

# verify using node -v. Should be 18
```

## Installing MariaDB
Source: https://www.digitalocean.com/community/tutorials/how-to-install-mariadb-on-ubuntu-20-04
```sh
sudo apt update

sudo apt install mariadb-server

sudo mysql_secure_installation

# The first prompt will ask you to enter the current database root password. Since you have not set one up yet, press ENTER to indicate “none”.

# You’ll be asked if you want to switch to unix socket authentication. Since you already have a protected root account, you can skip this step. Type n and then press ENTER.

# The next prompt asks you whether you’d like to set up a database root password. On Ubuntu, the root account for MariaDB is tied closely to automated system maintenance, so you should not change the configured authentication methods for that account.
```

## Secondary Software
```sh
sudo apt install python3-pip software-properties-common
sudo npm install -g yarn
apt-get install xvfb libfontconfig wkhtmltopdf
# sudo apt install redis-server python3-dev
# the above are part of core components so may not need to install them but verify
```

# Installing Frappe (Final Step):
`pip3 install frappe-bench`

Confirm Install
```sh
bench --version

# 5.x.x output
# Congrats!!
```
## Create frappe working directory
```sh
bench init frappe-bench

cd frappe-bench
bench start
```

# Next Step (Creating Apps)
https://frappeframework.com/docs/user/en/tutorial/create-an-app
