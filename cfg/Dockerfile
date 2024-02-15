FROM alpine:3.17.3
LABEL mantainer="NTTDATA Peru" \
      build="docker build --build-arg nombreArtefacto=artefacto -t microservicio:1.0 -f Dockerfile ." \
      run="docker run -dit --restart on-failure:5 --name microservicio -p 8080:8080 microservicio:1.0"

ENV JAVA_HOME=/usr/lib/jdk
ENV PATH=${PATH}:${JAVA_HOME}/bin

# Default to UTF-8 file.encoding
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en' LC_ALL='en_US.UTF-8'

# (Optional) Add extra packages for fontconfig and ttf-dejavu to support server-side image generation
RUN apk add --no-cache fontconfig libretls musl-locales musl-locales-lang ttf-dejavu tzdata zlib \
    && rm -rf /var/cache/apk/*

# Download and extract JDK 17
RUN wget -nv -O jdk.tar.gz https://aka.ms/download-jdk/microsoft-jdk-17.0.7-alpine-x64.tar.gz && \
    mkdir $JAVA_HOME && \
    tar xf jdk.tar.gz -C $JAVA_HOME --strip-components 1 --no-same-owner

ARG nombreArtefacto=artefacto.jar
ENV nombreArtefacto ${nombreArtefacto}
RUN apk update && apk upgrade \
	&& apk add ca-certificates \
	&& update-ca-certificates \
# Change TimeZone
	&& apk add --update tzdata
ENV TZ=America/Lima
# Copy *.jar and resources files
COPY ${nombreArtefacto} /opt/
WORKDIR /opt/
# Run service java
CMD ["sh","-c","java -jar ${nombreArtefacto}"]
# Clean APK cache
RUN rm -rf /var/cache/apk/*