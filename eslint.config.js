const js = require('@eslint/js');

module.exports = [
  {
    ignores: [
      'eslint.config.js',
      'node_modules/**',
      'target/**',
      'allure-report/**',
      'allure-report-ui/**',
      'allure-report-api/**',
      'allure-results/**'
    ]
  },
  js.configs.recommended,
  {
    files: ['**/*.{js,mjs,cjs}'],
    languageOptions: {
      ecmaVersion: 'latest',
      sourceType: 'module'
    },
    rules: {
      curly: 'error',
      eqeqeq: ['error', 'always'],
      'no-var': 'error',
      'prefer-const': 'error',
      'no-unused-vars': [
        'warn',
        {
          argsIgnorePattern: '^_',
          varsIgnorePattern: '^_'
        }
      ],
      'no-trailing-spaces': 'error',
      'eol-last': ['error', 'always'],
      semi: ['error', 'always'],
      quotes: ['warn', 'single', { avoidEscape: true }],
      'comma-dangle': ['error', 'never'],
      'object-curly-spacing': ['error', 'always']
    }
  }
];
