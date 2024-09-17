# Base image (for example, you can use a selenium image or Ubuntu base)
FROM selenium/hub:latest

# Install any additional dependencies (if required)
RUN apt-get update && apt-get install -y \
    curl \
    git

# Clone the repository inside the container
RUN git clone https://github.com/1rptr1/Page-Object-Model-Chrome.git /opt/project

# Set working directory
WORKDIR /opt/project

# Expose necessary ports
EXPOSE 4444

# Use docker-compose to run the setup (if you're using docker-compose.yml)
# If not using docker-compose, you can add instructions to run your grid setup here
CMD ["docker-compose", "up", "-d"]
