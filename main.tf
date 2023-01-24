resource "aws_iam_role" "iam_for_lambda" {
  name = "iam_for_lambda"
  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "sts:AssumeRole",
      "Principal": {
        "Service": "lambda.amazonaws.com"
      },
      "Effect": "Allow",
      "Sid": ""
    }
  ]
}
EOF
}

resource "aws_lambda_function" "test_lambda" {
  filename      = "target/sorting-api-0.0.1-SNAPSHOT.jar"
  function_name = "sort-api"
  role          = aws_iam_role.iam_for_lambda.arn
  handler       = "io.projects.sortingapi.StreamLambdaHandler::handleRequest"
  runtime = "java11"
}
