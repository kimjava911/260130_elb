```sh
docker build -t elb-test:latest .
# docker buildx build --platform linux/amd64,linux/arm64 -t elb-test:latest .
docker tag elb-test:latest ghcr.io/<username>/elb-test:latest
# docker tag elb-test:latest ghcr.io/kimjava911/elb-test:latest
```

```sh
# https://github.com/settings/tokens/new
export CR_PAT=ghp_******
echo $CR_PAT | docker login ghcr.io -u <username> --password-stdin
# echo $CR_PAT | docker login ghcr.io -u kimjava911 --password-stdin
docker push ghcr.io/<username>/elb-test:latest
# docker push ghcr.io/kimjava911/elb-test:latest
```

```sh
chmod 400 *.pem
ssh -i "???.pem" ubuntu@???
# ssh -i "test.pem" ubuntu@ec2-16-184-43-48.ap-northeast-2.compute.amazonaws.com
# ssh -i "test.pem" ubuntu@ec2-16-184-19-228.ap-northeast-2.compute.amazonaws.com
```

```sh
sudo apt update
curl -fsSL https://get.docker.com -o get-docker.sh
sudo sh get-docker.sh

sudo usermod -aG docker $USER
exit

```

```sh
export CR_PAT=ghp_******
echo $CR_PAT | docker login ghcr.io -u <username> --password-stdin
# echo $CR_PAT | docker login ghcr.io -u kimjava911 --password-stdin
docker pull ghcr.io/<username>/elb-test:latest && docker tag ghcr.io/<username>/elb-test:latest elb-test:latest
# docker pull ghcr.io/kimjava911/elb-test:latest && docker tag ghcr.io/kimjava911/elb-test:latest elb-test:latest  
```

```sh
docker run --name app-1 -e APP_NAME=app-1 -p 8080:8080 -d elb-test:latest
docker run --name app-2 -e APP_NAME=app-2 -p 8080:8080 -d elb-test:latest
curl localhost:8080
```