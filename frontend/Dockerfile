FROM nginx:latest

COPY ./build /usr/share/nginx/html
COPY ./nginx_template /etc/nginx/templates

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]