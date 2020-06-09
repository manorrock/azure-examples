#
# Use Debian
#
FROM debian

#
# Install curl, tar and unzip.
#
RUN apt-get update && \
    apt-get install -y curl tar unzip && \
    rm -rf /var/lib/apt/lists/*

#
# Install AdoptOpenJDK 8.
#
RUN cd /usr/local && \
    curl --insecure -L -O https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09/OpenJDK8U-jdk_x64_linux_hotspot_8u252b09.tar.gz && \
    tar xfvz OpenJDK8U-jdk_x64_linux_hotspot_8u252b09.tar.gz && \
    mv jdk8u252-b09 jdk && \
    rm OpenJDK8U-jdk_x64_linux_hotspot_8u252b09.tar.gz

#
# Setup path
#
ENV PATH=$PATH:/usr/local/jdk/bin

#
# Install Glassfish
#
RUN export GLASSFISH_VERSION=5.1.0 && \
    cd /usr/local && \
    curl -L -o glassfish.zip https://www.eclipse.org/downloads/download.php?file=/glassfish/glassfish-${GLASSFISH_VERSION}.zip\&r=1 && \
    unzip glassfish.zip && \
    rm glassfish.zip && \
    rm -rf /var/lib/apt/lists/*

#
# Expose port 8080
#
EXPOSE 8080

#
# Startup command
#
CMD ["/usr/local/glassfish5/glassfish/bin/asadmin", "start-domain", "-v"]
