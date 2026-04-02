---
name: git-commit-helper
description: 当用户请求"帮我提交代码"、"git commit"或类似明确指令时触发。帮助用户生成 Conventional Commits 格式的 commit message，显示 untracked files 供用户选择排除，生成 diff 展示，确认后执行 add → commit → push。
---

# Git Commit Helper

帮助用户完成本地代码提交的完整工作流：检测未追踪文件 → 用户选择排除 → 显示 diff → 生成 commit message → 确认后提交并推送。

## 触发条件

当用户明确请求提交代码时触发，例如：
- "帮我提交代码"
- "git commit"
- "生成 commit message"
- "提交并推送"

## 工作流程

### Step 1: 检测 git 状态

执行以下命令检查当前仓库状态：
```bash
git status
```

### Step 2: 获取并展示 untracked files

使用 `git ls-files --others --exclude-standard` 获取所有未追踪的新文件（不包括已修改的文件）。

将文件列表展示给用户，格式如下：
```
未追踪文件列表：
1. src/utils/Helper.java
2. src/config/AppConfig.java
3. README.md

请输入要排除的文件编号（多个用逗号分隔），或直接回车继续：
```

### Step 3: 用户选择排除文件

等待用户输入。用户可以：
- 输入数字（如 `1,3`）排除第1和第3个文件
- 输入 `all` 包含所有文件
- 直接回车包含所有文件

### Step 4: 显示选中文件的 diff

对于用户选中的文件，执行 `git diff` 展示变更内容。

如果选中的文件较少，可以直接显示完整 diff。如果较多，可以显示摘要（修改行数统计）。

### Step 5: 生成 commit message

分析 diff 内容，生成符合 Conventional Commits 格式的 commit message：

格式：`type(scope): description`

常用 type：
- `feat`: 新功能
- `fix`: Bug 修复
- `docs`: 文档更新
- `style`: 代码格式
- `refactor`: 重构
- `test`: 测试相关
- `chore`: 构建/工具

示例输出：
```
生成的 Commit Message：
feat(config): add application configuration loader

是否确认此 commit message？（输入新的 message 覆盖，或直接回车确认）
```

### Step 6: 用户确认 commit message

等待用户确认：
- 直接回车：使用生成的 message
- 输入新内容：使用用户输入的 message
- 输入 `cancel`：取消操作

### Step 7: 执行提交和推送

用户确认后依次执行：

1. `git add <选中文件>`
2. `git commit -m "<确认的 message>"`
3. `git push`

展示执行结果，确认推送成功。

## 注意事项

- 仅处理 untracked files（新增未追踪文件），不处理已修改文件
- 如果没有 untracked files，提示用户并询问是否要提交已暂存的更改
- 如果用户取消操作，明确提示已取消
- 提交前检查是否有未追踪但不需要提交的文件被包含
- 使用 `git ls-files --others --exclude-standard` 确保排除 .gitignore 中的文件
