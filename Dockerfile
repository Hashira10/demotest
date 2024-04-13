FROM heroku/heroku:22-build AS builder

FROM heroku/heroku:22 AS production

ARG RAILS_ENV=production
ARG FOO
