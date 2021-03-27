rootProject.name = "casino"
include("backend")
findProject(":backend")?.name = "casino-backend"
include("frontend")
findProject(":frontend")?.name = "casino-frontend"

