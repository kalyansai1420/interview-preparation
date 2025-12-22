# Kubernetes Interview Questions – Deep & Clear Answers
## Iteration 1/2 (Q1–Q21)

---

## Q1. What is Kubernetes, and why is it used for container orchestration?

**Answer:**  
Kubernetes is an open-source container orchestration platform used to deploy, manage, scale, and heal containerized applications automatically.

**Scenario:**  
Instead of manually starting containers on servers, Kubernetes ensures the required number of containers are always running and restarts them if they fail.

**Pitfalls:**  
- Thinking Kubernetes replaces Docker (it manages containers, not builds them)  
- Using Kubernetes for very small apps  

**Trade-offs:**  
Provides automation and resilience but introduces operational complexity.

---

## Q2. Describe the roles of master and worker nodes in Kubernetes architecture.

**Answer:**  
Master nodes control the cluster (API server, scheduler, controller manager), while worker nodes run application workloads using Pods.

**Scenario:**  
Master decides *where* a Pod runs; worker executes it.

**Pitfalls:**  
- Running workloads on master nodes  
- Single master without HA  

**Trade-offs:**  
Centralized control improves coordination but requires HA for reliability.

---

## Q3. How do Pods facilitate the management of containers in Kubernetes?

**Answer:**  
A Pod is the smallest deployable unit in Kubernetes and can contain one or more containers that share networking and storage.

**Scenario:**  
A logging sidecar runs alongside an app container inside the same Pod.

**Pitfalls:**  
- Running multiple unrelated apps in one Pod  

**Trade-offs:**  
Pods simplify co-located containers but reduce independent scaling.

---

## Q4. What types of Services exist in Kubernetes, and how do they facilitate pod communication?

**Answer:**  
Kubernetes Services expose Pods using stable networking via ClusterIP, NodePort, LoadBalancer, or ExternalName.

**Scenario:**  
A Service routes traffic to healthy Pods even if Pod IPs change.

**Pitfalls:**  
- Using NodePort in production unnecessarily  

**Trade-offs:**  
Services abstract Pod churn but add a networking layer.

---

## Q5. Explain the functionality of Namespaces in Kubernetes.

**Answer:**  
Namespaces logically isolate resources within a cluster, enabling multi-tenancy and access control.

**Scenario:**  
Dev and Prod workloads exist in separate namespaces.

**Pitfalls:**  
- Assuming namespaces provide strong security isolation  

**Trade-offs:**  
Good for organization, not a security boundary by itself.

---

## Q6. Differentiate between Deployments, StatefulSets, and DaemonSets.

**Answer:**  
Deployments manage stateless apps, StatefulSets manage stateful apps with stable identities, and DaemonSets ensure one Pod per node.

**Scenario:**  
Deployment for web app, StatefulSet for database, DaemonSet for monitoring agent.

**Pitfalls:**  
- Using Deployment for stateful workloads  

**Trade-offs:**  
Each controller is optimized for a specific workload type.

---

## Q7. How do ReplicaSets ensure pod availability?

**Answer:**  
ReplicaSets ensure a specified number of Pod replicas are always running.

**Scenario:**  
If one Pod crashes, ReplicaSet automatically creates a new one.

**Pitfalls:**  
- Managing ReplicaSets directly instead of Deployments  

**Trade-offs:**  
Ensures availability but lacks rollout features.

---

## Q8. What are Jobs in Kubernetes, and when is it suitable to use them?

**Answer:**  
Jobs run Pods until a task completes successfully and then stop.

**Scenario:**  
Database migration or batch processing task.

**Pitfalls:**  
- Using Jobs for long-running services  

**Trade-offs:**  
Reliable for one-time tasks, not continuous workloads.

---

## Q9. How do Labels and Selectors work together in Kubernetes?

**Answer:**  
Labels tag resources, and selectors query those tags to group resources.

**Scenario:**  
A Service selects Pods with label `app=orders`.

**Pitfalls:**  
- Changing labels without updating selectors  

**Trade-offs:**  
Flexible grouping but requires consistency.

---

## Q10. What would you consider when performing a rolling update in Kubernetes?

**Answer:**  
Consider availability, rollout speed, readiness probes, and rollback strategy.

**Scenario:**  
Deploy new version gradually without downtime.

**Pitfalls:**  
- No readiness probes → traffic sent too early  

**Trade-offs:**  
Safer updates but slower rollout.

---

## Q11. How do Services route traffic to pods in Kubernetes?

**Answer:**  
Services use kube-proxy and iptables/IPVS rules to route traffic to healthy Pods.

**Scenario:**  
Service load-balances traffic across Pods.

**Pitfalls:**  
- Assuming round-robin always happens  

**Trade-offs:**  
Abstracts networking complexity but reduces fine control.

---

## Q12. Describe the purpose of Ingress and its key components.

**Answer:**  
Ingress manages external HTTP/HTTPS access to services using routing rules.

**Scenario:**  
Expose multiple services via a single domain.

**Pitfalls:**  
- Ingress without controller does nothing  

**Trade-offs:**  
Simplifies routing but adds configuration complexity.

---

## Q13. Explain Kubernetes DNS resolution for services.

**Answer:**  
Kubernetes provides DNS names for Services, allowing Pods to communicate using service names.

**Scenario:**  
`orders.default.svc.cluster.local`

**Pitfalls:**  
- Hardcoding IPs  

**Trade-offs:**  
DNS simplifies discovery but introduces dependency on CoreDNS.

---

## Q14. What is the Container Network Interface (CNI), and how does it integrate with Kubernetes?

**Answer:**  
CNI defines how Pods get networking. Kubernetes relies on CNI plugins like Calico or Flannel.

**Scenario:**  
CNI assigns IPs to Pods across nodes.

**Pitfalls:**  
- Misconfigured CNI breaks networking  

**Trade-offs:**  
Pluggable networking but adds complexity.

---

## Q15. How do you implement Network Policies, and what are their benefits?

**Answer:**  
Network Policies control Pod-to-Pod traffic using allow/deny rules.

**Scenario:**  
Only backend Pods can talk to database Pods.

**Pitfalls:**  
- Assuming default deny without defining policies  

**Trade-offs:**  
Improves security but requires careful planning.

---

## Q16. How do PersistentVolumes (PVs) and PersistentVolumeClaims (PVCs) interact?

**Answer:**  
PVs represent storage resources; PVCs request storage from them.

**Scenario:**  
A database Pod claims storage using PVC.

**Pitfalls:**  
- Hardcoding storage paths  

**Trade-offs:**  
Decouples storage from Pods.

---

## Q17. Explain dynamic provisioning in relation to StorageClasses.

**Answer:**  
StorageClasses allow Kubernetes to provision storage automatically when PVCs are created.

**Scenario:**  
PVC triggers automatic cloud disk creation.

**Pitfalls:**  
- No default StorageClass  

**Trade-offs:**  
Automation vs reduced manual control.

---

## Q18. What strategies exist for handling persistent data when a pod’s lifecycle ends?

**Answer:**  
Use PVs, PVCs, and StatefulSets to preserve data beyond Pod lifecycle.

**Scenario:**  
Database Pod restarts without data loss.

**Pitfalls:**  
- Storing data in Pod filesystem  

**Trade-offs:**  
Persistent storage adds management overhead.

---

## Q19. Describe the process for initializing a Kubernetes cluster.

**Answer:**  
Cluster initialization includes setting up control plane, networking, and joining worker nodes.

**Scenario:**  
Using kubeadm to initialize cluster.

**Pitfalls:**  
- Missing CNI setup  

**Trade-offs:**  
Manual setup offers control but managed services simplify it.

---

## Q20. What factors need to be considered when adding new nodes to a Kubernetes cluster?

**Answer:**  
Consider resource capacity, labels, taints, networking, and security.

**Scenario:**  
Adding GPU nodes for ML workloads.

**Pitfalls:**  
- Not labeling nodes  

**Trade-offs:**  
Scaling nodes improves capacity but increases cost.

---

## Q21. How does draining a node affect running applications, and when should you perform this action?

**Answer:**  
Draining evicts Pods safely so they can be rescheduled elsewhere.

**Scenario:**  
Before node maintenance or upgrade.

**Pitfalls:**  
- Draining without PodDisruptionBudgets  

**Trade-offs:**  
Ensures safety but may temporarily reduce capacity.

---
# Kubernetes Interview Questions – Complete Guide
## Iteration 2/2 (Q22–Q42)
_Source: k8s-interview-questions.pdf_

---

## Q22. How does Kubernetes handle application scaling?

**Answer:**  
Kubernetes handles scaling by increasing or decreasing the number of Pod replicas for an application, either manually or automatically using controllers.

**Scenario:**  
During peak traffic, Kubernetes adds more Pods for a web application to handle increased load.

**Pitfalls:**  
- Scaling Pods without scaling underlying resources (CPU, memory)  
- Ignoring database or external service limits  

**Trade-offs:**  
Horizontal scaling improves availability but increases resource usage.

---

## Q23. What is the Horizontal Pod Autoscaler (HPA), and how does it work?

**Answer:**  
HPA automatically scales the number of Pods based on observed metrics such as CPU or memory utilization.

**Scenario:**  
When CPU usage crosses 70%, HPA increases Pod replicas.

**Pitfalls:**  
- Missing Metrics Server  
- Poorly chosen thresholds  

**Trade-offs:**  
Autoscaling improves responsiveness but may cause frequent scaling if not tuned.

---

## Q24. How do you perform rolling updates and rollbacks in Kubernetes?

**Answer:**  
Rolling updates replace Pods gradually with new versions, and rollbacks revert to previous versions if issues arise.

**Scenario:**  
Deploy version v2 while v1 Pods are still serving traffic.

**Pitfalls:**  
- No readiness probes  
- Breaking backward compatibility  

**Trade-offs:**  
Rolling updates reduce downtime but slow deployments.

---

## Q25. What is the purpose of readiness and liveness probes?

**Answer:**  
Readiness probes determine when a Pod can receive traffic; liveness probes determine when it should be restarted.

**Scenario:**  
App starts slowly; readiness probe prevents traffic too early.

**Pitfalls:**  
- Using only liveness probes  
- Aggressive probe settings  

**Trade-offs:**  
Improves reliability but needs tuning.

---

## Q26. How does Kubernetes ensure high availability of applications?

**Answer:**  
High availability is ensured by running multiple replicas across nodes and zones with self-healing and rescheduling.

**Scenario:**  
If a node fails, Pods restart on healthy nodes.

**Pitfalls:**  
- Single replica workloads  
- Single availability zone  

**Trade-offs:**  
HA increases cost but improves uptime.

---

## Q27. What is PodDisruptionBudget (PDB), and why is it important?

**Answer:**  
PDB limits the number of Pods that can be disrupted simultaneously during maintenance.

**Scenario:**  
Ensure at least 2 replicas remain available during upgrades.

**Pitfalls:**  
- Overly strict PDB blocking upgrades  

**Trade-offs:**  
Protects availability but can slow maintenance.

---

## Q28. How does Kubernetes handle secret management?

**Answer:**  
Kubernetes stores secrets securely and injects them into Pods as environment variables or volumes.

**Scenario:**  
Database password injected into app Pod at runtime.

**Pitfalls:**  
- Storing secrets in plain text YAML  
- Logging secret values  

**Trade-offs:**  
Convenient but requires RBAC and encryption-at-rest.

---

## Q29. What is Role-Based Access Control (RBAC) in Kubernetes?

**Answer:**  
RBAC defines who can perform what actions on which resources.

**Scenario:**  
Developers can deploy apps but not delete namespaces.

**Pitfalls:**  
- Overly permissive roles  

**Trade-offs:**  
Improves security but adds management complexity.

---

## Q30. How do SecurityContexts improve Pod security?

**Answer:**  
SecurityContexts define privileges such as user ID, file permissions, and capabilities.

**Scenario:**  
Run containers as non-root user.

**Pitfalls:**  
- Ignoring security context defaults  

**Trade-offs:**  
Stronger security but may require image changes.

---

## Q31. How do you monitor Kubernetes clusters and applications?

**Answer:**  
Monitoring is done using Metrics Server, Prometheus, and Grafana for metrics and alerts.

**Scenario:**  
Dashboard shows CPU usage and Pod health.

**Pitfalls:**  
- Monitoring infrastructure but not applications  

**Trade-offs:**  
Monitoring adds overhead but is essential.

---

## Q32. What is the Metrics Server, and why is it important?

**Answer:**  
Metrics Server collects resource usage metrics used by HPA.

**Scenario:**  
HPA uses Metrics Server to scale Pods.

**Pitfalls:**  
- Metrics Server missing or misconfigured  

**Trade-offs:**  
Lightweight but limited metrics.

---

## Q33. How does Kubernetes logging work?

**Answer:**  
Kubernetes collects container stdout/stderr logs; external systems aggregate them.

**Scenario:**  
Logs shipped to ELK stack.

**Pitfalls:**  
- Writing logs to container filesystem  

**Trade-offs:**  
Simple logging but needs external tools.

---

## Q34. How do you troubleshoot a failing Pod?

**Answer:**  
Use `kubectl describe`, `kubectl logs`, and `kubectl exec` to diagnose issues.

**Scenario:**  
Pod crash due to missing environment variable.

**Pitfalls:**  
- Debugging without checking events  

**Trade-offs:**  
Fast troubleshooting but needs cluster access.

---

## Q35. What are taints and tolerations?

**Answer:**  
Taints repel Pods from nodes unless tolerated.

**Scenario:**  
GPU nodes only accept GPU workloads.

**Pitfalls:**  
- Forgetting tolerations  

**Trade-offs:**  
Better scheduling control but adds complexity.

---

## Q36. Explain node affinity and pod affinity.

**Answer:**  
Affinity rules guide Pods to preferred nodes or co-locate/separate Pods.

**Scenario:**  
Keep cache Pods close to app Pods.

**Pitfalls:**  
- Over-constraining scheduling  

**Trade-offs:**  
Optimizes placement but reduces flexibility.

---

## Q37. What is a Custom Resource Definition (CRD)?

**Answer:**  
CRDs extend Kubernetes API with custom resource types.

**Scenario:**  
Define a custom MLJob resource.

**Pitfalls:**  
- Lack of validation  

**Trade-offs:**  
Extensible but requires operator logic.

---

## Q38. How do Operators work in Kubernetes?

**Answer:**  
Operators automate operational tasks using controllers and CRDs.

**Scenario:**  
Database Operator handles backups and upgrades.

**Pitfalls:**  
- Poorly written operators  

**Trade-offs:**  
Automation vs complexity.

---

## Q39. What is Helm, and how does it help Kubernetes deployments?

**Answer:**  
Helm is a package manager that templatizes Kubernetes manifests.

**Scenario:**  
Deploy app using Helm chart with configurable values.

**Pitfalls:**  
- Over-templating  

**Trade-offs:**  
Simplifies deployment but hides complexity.

---

## Q40. What is Kustomize, and how is it different from Helm?

**Answer:**  
Kustomize customizes YAML without templates, using overlays.

**Scenario:**  
Same base config for dev and prod with overlays.

**Pitfalls:**  
- Managing many overlays  

**Trade-offs:**  
Simple and declarative but less flexible.

---

## Q41. What is a Service Mesh, and how does it integrate with Kubernetes?

**Answer:**  
A service mesh manages service-to-service communication with sidecar proxies.

**Scenario:**  
Enable mTLS and traffic control without app changes.

**Pitfalls:**  
- Debugging complexity  

**Trade-offs:**  
Powerful but resource-intensive.

---

## Q42. What are Kubernetes best practices for production environments?

**Answer:**  
Use namespaces, RBAC, resource limits, probes, autoscaling, monitoring, and secure images.

**Scenario:**  
Production cluster follows least-privilege and observability principles.

**Pitfalls:**  
- Running without limits or probes  

**Trade-offs:**  
More setup but far more stable systems.

---
