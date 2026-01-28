# Dockerfile
FROM python:3.11-slim
WORKDIR /app
COPY app.py /app/
COPY requirements.txt /app/
RUN pip install --no-cache-dir -r requirements.txt
ENV CONFIG_PATH=/config/config.yaml
EXPOSE 8080
CMD ["python", "app.py"]
