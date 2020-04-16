FROM debian
EXPOSE 8080
COPY target/graalvm /opt/graalvm/graalvm
COPY src/main/docker/entrypoint.sh /opt/graalvm/entrypoint.sh
RUN chmod a+x /opt/graalvm/entrypoint.sh
ENTRYPOINT ["/opt/graalvm/entrypoint.sh"]
CMD ["/opt/graalvm/graalvm"]
