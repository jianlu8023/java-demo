#CUR_DIR:=$(notdir $(shell dirname $(abspath $(MAKEFILE_LIST))))
#CDIR:=$(dir $(abspath $(MAKEFILE_LIST)))
#CDIRNAME:=$(shell dirname $(CDIR))
#
#DOCKER_FILE:= $(lastword $(CUR_DIR))/Dockerfile
DOCKER_FILE:=Dockerfile
CUR_TIME:= $(shell date +"%Y%m%d%H%M")
IMAGE_VERSION:=v$(CUR_TIME)
IMAGE_NAME:=java-demo/alpine/integration:$(IMAGE_VERSION)

version ?= 1.0.0

.PHONY: build


build:
#	@echo "Current Dir: $(CUR_DIR)"
#	@echo "Dockerfile : $(DOCKER_FILE)"
#	@echo "Current Time: $(CUR_TIME)"
#	@echo "Image Version: $(IMAGE_VERSION)"
	@echo "Image Name: $(IMAGE_NAME)"
	docker buildx build -t "$(IMAGE_NAME)" --no-cache -f "$(DOCKER_FILE)" .
	docker builder prune -a -f
	@echo "done"

#build:
#	docker buildx build -t java-demo-integration:${version} .
#	docker builder prune -f -a
