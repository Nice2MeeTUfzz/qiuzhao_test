---
name: git-commit-helper
description: 当用户请求"帮我提交代码"、"git commit"或类似明确指令时触发。帮助用户生成 Conventional Commits 格式的中文 commit message，分别展示 modified 和 untracked files 供用户选择排除，生成 diff 展示，确认后执行 add → commit → push。
---

# Git Commit Helper

帮助用户完成本地代码提交的完整工作流：检测 modified + untracked 文件 → 用户分别选择排除 → 显示 diff → 生成 commit message → 确认后提交并推送。

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

### Step 2: 获取并分别展示两类文件

**获取 modified files（已修改文件）：**
```bash
git diff --name-only
```

**获取 untracked files（新增未追踪文件）：**
```bash
git ls-files --others --exclude-standard
```

**分别展示给用户：**

```
=== Modified Files (已修改文件) ===
1. src/美团/无限循环.java
2. src/算法/QuickSort.java

请输入要排除的文件编号（多个用逗号分隔），或直接回车继续包含全部：

=== Untracked Files (新增未追踪文件) ===
1. .opencode/skills/
2. qiuzhao_test.iml

请输入要排除的文件编号（多个用逗号分隔），或直接回车继续包含全部：
```

### Step 3: 用户选择排除文件

等待用户输入。用户可以：
- 输入数字（如 `1,3`）排除第1和第3个文件
- 输入 `all` 包含所有文件
- 直接回车包含所有文件

先处理 modified files，再处理 untracked files。

### Step 4: 合并显示选中文件的 diff

对于用户选中的所有文件，执行 `git diff` 展示变更内容。

对于 untracked files，使用 `git diff --no-index /dev/null <file>` 显示新增文件内容。

如果文件较多，可以显示摘要（修改行数统计）。

### Step 5: 生成 commit message

分析 diff 内容，生成符合 Conventional Commits 格式的**中文** commit message：

格式：`type(scope): description`

常用 type（中文描述）：
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
feat(美团): 添加无限循环解法

是否确认此 commit message？（输入新的 message 覆盖，或直接回车确认）
```

### Step 6: 用户确认 commit message

等待用户确认：
- 直接回车：使用生成的 message
- 输入新内容：使用用户输入的 message
- 输入 `cancel`：取消操作

### Step 7: 执行提交和推送

用户确认后依次执行：

1. `git add <选中的 modified files>`
2. `git add <选中的 untracked files>`
3. `git commit -m "<确认的 message>"`
4. `git push`

展示执行结果，确认推送成功。

## 注意事项

- 同时处理 modified files（已修改）和 untracked files（新增未追踪）
- 两类文件分别展示，让用户可以分别选择排除
- 如果没有 modified files，跳过 modified files 选择步骤
- 如果没有 untracked files，跳过 untracked files 选择步骤
- 如果两者都没有，提示用户"没有需要提交的更改"
- 如果用户取消操作，明确提示已取消
- 使用 `git ls-files --others --exclude-standard` 确保排除 .gitignore 中的文件
