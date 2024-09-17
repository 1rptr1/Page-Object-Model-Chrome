#!/bin/bash

# Update the package list
sudo apt update

# Install Docker
sudo apt install -y docker.io

# Start and enable Docker
sudo systemctl start docker
sudo systemctl enable docker

# Install Docker Compose
sudo curl -L "https://github.com/docker/compose/releases/download/$(curl -s https://api.github.com/repos/docker/compose/releases/latest | grep -Po '"tag_name": "\K[0-9.]+')" /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

# Clone your repository (if not already cloned)
git clone https://github.com/1rptr1/Page-Object-Model-Chrome.git || echo "Repo already cloned"
cd Page-Object-Model-Chrome

# Build the Docker image from Dockerfile
docker build -t selenium-grid-chrome .

# Run Docker Compose to set up containers
docker-compose up -d

# Open ports on the VM's firewall
sudo ufw allow 4444/tcp
sudo ufw reload

# Display public IP (to access Selenium Grid externally)
echo "Setup complete. You can access Selenium Grid at http://$(curl ifconfig.me):4444/wd/hub"
