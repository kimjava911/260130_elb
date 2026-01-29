```sh
docker build -t elb-test:latest .
# docker buildx build --platform linux/amd64,linux/arm64 -t elb-test:latest .
docker tag elb-test:latest ghcr.io/<username>/elb-test:latest
```

```sh
# https://github.com/settings/tokens/new
export CR_PAT=ghp_******
echo $CR_PAT | docker login ghcr.io -u <username> --password-stdin
docker push ghcr.io/<username>/elb-test:latest
```

```sh
export CR_PAT=ghp_******
echo $CR_PAT | docker login ghcr.io -u <username> --password-stdin
docker pull ghcr.io/<username>/elb-test:latest \
  && docker tag ghcr.io/<username>/elb-test:latest elb-test:latest
```

```sh
docker run --name app-1 -e APP_NAME=app-1 -d elb-test:latest
docker run --name app-2 -e APP_NAME=app-2 -d elb-test:latest
```