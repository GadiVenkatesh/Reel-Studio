# High Level Design

## Architecture
Frontend (Next.js)
 -> API Gateway
 -> Auth Service
 -> AI Orchestrator
 -> Media Service
 -> Analytics Service

Infrastructure:
- PostgreSQL
- Redis
- Kafka
- S3
- Kubernetes

## AI Pipeline
Prompt -> Script -> Storyboard -> Voice -> Captions -> Render -> Publish
